'use strict';

angular.module('ficheprojetApp').factory('ClientService', [ '$resource', function($resource) {

    return $resource('api/clients/:idClient', {
	idClient : '@idClient'
    }, {
	update : {
	    method : 'PUT'
	}
    });

} ]);