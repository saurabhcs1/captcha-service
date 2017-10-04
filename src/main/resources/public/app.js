angular.module('app', [])
    .controller('Captcha', function($scope, $http) {

        $scope.answer = 0;

        $http.get('/api/GetQuestion').
        then(function(response) {
            $scope.question = response.data;
        });

        $scope.checkAnswer = function() {

            var dataObj = {
                question : $scope.question.question,
                token : $scope.question.token,
                answer : $scope.answer
            };

            var res = $http.post('/api/AnswerQuestion', dataObj);
            res.success(function(data, status, headers, config) {
                $scope.message = data;
            });
            res.error(function(data, status, headers, config) {
                $scope.message = data;
            });

        };
    });