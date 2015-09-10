'use strict';

angular.module('ficheprojetApp').factory('FunctionService', [ '$resource', function($resource) {

    return $resource('api/functions/:idFunction', {
	idFunction : '@idFunction'
    }, {
	update : {
	    method : 'PUT'
	}
    });
} ]);