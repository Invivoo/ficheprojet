'use strict';

angular.module('ficheprojetApp').directive('confirmClickDirective', ['$q', 'dialogModal', function($q, dialogModal) {
   return {
       link: function (scope, element, attrs) {

    	   var ngClick = attrs.ngClick.replace('confirmClick($event)', 'true');

           // setup a confirmation action on the scope
           scope.confirmClick = function($event) {

        	   $event.stopPropagation();
               
               dialogModal('Are you sure?').result.then(function() {
                   scope.$eval(ngClick);
               });
               // return false to stop the current ng-click flow and wait for our modal answer
               return false;
           };
       }
   }
}]).service('dialogModal', ['$modal', function($modal) {
   return function (message, title, okButton, cancelButton) {
       // setup default values for buttons
       // if a button value is set to false, then that button won't be included
       okButton = okButton===false ? false : (okButton || 'Confirm');
       cancelButton = cancelButton===false ? false : (cancelButton || 'Cancel');

       // setup the Controller to watch the click
       var ModalInstanceCtrl = function ($scope, $modalInstance, settings) {
           // add settings to scope
           angular.extend($scope, settings);
           // ok button clicked
           $scope.ok = function () {
               $modalInstance.close(true);
           };
           // cancel button clicked
           $scope.cancel = function () {
               $modalInstance.dismiss('cancel');
           };
       };

       // open modal and return the instance (which will resolve the promise on ok/cancel clicks)
       var modalInstance = $modal.open({
           template: '<style>.center-modal {top: 30%;}</style><div class="dialog-modal"> \
               <div class="modal-header" ng-show="modalTitle"> \
                   <h3 class="modal-title">{{modalTitle}}</h3> \
               </div> \
               <div class="modal-body">{{modalBody}}</div> \
               <div class="modal-footer"> \
                   <button class="btn btn-success" ng-click="ok()" ng-show="okButton">{{okButton}}</button> \
                   <button class="btn btn-warning" ng-click="cancel()" ng-show="cancelButton">{{cancelButton}}</button> \
               </div> \
           </div>',
           controller: ModalInstanceCtrl,
           windowClass: 'center-modal',
           resolve: {
               settings: function() {
                   return {
                       modalTitle: title,
                       modalBody: message,
                       okButton: okButton,
                       cancelButton: cancelButton
                   };
               }
           }
       });
       // return the modal instance
       return modalInstance;
   }
}]);