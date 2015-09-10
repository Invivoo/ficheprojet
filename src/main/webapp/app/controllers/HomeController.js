'use strict';

angular.module('ficheprojetApp').controller(
		'HomeController',
		[ '$scope', '$state', 'PrincipalService',
				function($scope, $state, PrincipalService) {

					var vm = this;
					$scope.$state = $state;

					PrincipalService.identity().then(function(account) {
						vm.account = account;
					});

				} ]);
