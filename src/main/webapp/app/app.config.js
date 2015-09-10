'use strict';

angular.module('ficheprojetApp').config(
	[ '$httpProvider', 'tmhDynamicLocaleProvider', 'httpRequestInterceptorCacheBusterProvider',
		function($httpProvider, tmhDynamicLocaleProvider, httpRequestInterceptorCacheBusterProvider) {

		    $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
		    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';

		    // Cache everything except rest api requests
		    httpRequestInterceptorCacheBusterProvider.setMatchlist([ /.*api.*/, /.*protected.*/ ], true);

		    $httpProvider.interceptors.push('AuthExpiredInterceptor');

		    tmhDynamicLocaleProvider.localeLocationPattern('bower_components/angular-i18n/angular-locale_{{locale}}.js');
		    tmhDynamicLocaleProvider.useCookieStorage();
		    tmhDynamicLocaleProvider.storageKey('NG_TRANSLATE_LANG_KEY');

		} ]);
