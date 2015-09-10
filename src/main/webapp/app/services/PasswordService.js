'use strict';

angular.module('ficheprojetApp').factory('PasswordService', [ '$resource', function($resource) {

    return {

	changePassword : function(newPassword, callback) {
	    var cb = callback || angular.noop;

	    return $resource('api/account/change_password', {}, {}).save(newPassword, function() {
		return cb();
	    }, function(err) {
		return cb(err);
	    }).$promise;
	},

	resetPasswordInit : function(mail, callback) {
	    var cb = callback || angular.noop;

	    return $resource('api/account/reset_password/init', {}, {}).save(mail, function() {
		return cb();
	    }, function(err) {
		return cb(err);
	    }).$promise;
	},

	resetPasswordFinish : function(key, newPassword, callback) {
	    var cb = callback || angular.noop;

	    return $resource('api/account/reset_password/finish', {}, {}).save(key, newPassword, function() {
		return cb();
	    }, function(err) {
		return cb(err);
	    }).$promise;
	}
    }
} ]);
