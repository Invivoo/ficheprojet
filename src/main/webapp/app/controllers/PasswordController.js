'use strict';

angular.module('ficheprojetApp').controller('PasswordController', ['PasswordService', 'PrincipalService', function (PasswordService, PrincipalService) {
	
	var vm = this;
	
	PrincipalService.identity().then(function(account) {
            vm.account = account;
        });

	vm.ERROR_STATUS = null;
	vm.SUCCESS_STATUS = null;
	vm.DO_NOT_MATCH_STATUS = null;
	vm.INCORRECT_PASSWORD_STATUS=null;
	
	vm.changePassword = function () {
            if (vm.password !== vm.confirmPassword) {
        	vm.DO_NOT_MATCH_STATUS = 'KO';
            } else {
        	vm.DO_NOT_MATCH_STATUS = null;
        	PasswordService.changePassword(vm.password).then(function () {
                    vm.ERROR_STATUS = null;
                    vm.SUCCESS_STATUS = 'OK';
                }).catch(function (error) {
                    if (error.status === 400 && error.data.message === 'INCORRECT_PASSWORD_STATUS') {
                	vm.INCORRECT_PASSWORD_STATUS = 'KO';
                    }else{
                	vm.SUCCESS_STATUS = null;
                	vm.ERROR_STATUS = 'KO';
                    }
                });
            }
        };
    }]);
