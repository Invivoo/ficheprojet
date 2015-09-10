'use strict';

angular.module('ficheprojetApp').factory('AccountService', [ '$resource', function($resource) {

    return $resource('api/account/useraccount', {}, {
	'get' : {
	    method : 'GET',
	    params : {},
	    isArray : false,
	    interceptor : {
		response : function(response) {
		    // expose response
		    return response;
		}
	    }
	}
    });
} ]);
