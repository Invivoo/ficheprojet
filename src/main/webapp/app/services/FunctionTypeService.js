'use strict';

angular.module('ficheprojetApp').factory('FunctionTypeService', [ '$resource', function($resource) {

    return $resource('api/function-types/:idFunctionType', {
	idFunctionType : '@idFunctionType'
    }, {
	update : {
	    method : 'PUT'
	}
    });
} ]);