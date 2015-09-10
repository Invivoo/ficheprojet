'use strict';

angular.module('ficheprojetApp').controller('UserMissionController', [ 'PrincipalService', 'MissionService', function(PrincipalService, MissionService) {

    var vm = this;

    PrincipalService.identity().then(function(account) {

	MissionService.query({}, {
	    loginId : account.login
	}, function(data) {
	    vm.missions = data;
	});
    });
    
    vm.deleteMission = function(index,mission) { 
    	PrincipalService.identity().then(function(account) {
		MissionService.delete({}, { idMission:mission.id },function(){
		    vm.missions.splice(index, 1);
		});
    	});
    };
    
} ]);
