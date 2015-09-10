'use strict';

angular.module('ficheprojetApp').factory('MissionService', [ '$resource', function($resource) {

    return $resource('api/:loginId/missions/:idMission', {
	loginId : '@loginId',
	idMission : '@idMission'
    }, {
	update : {
	    method : 'PUT'
	}
    });
} ]);