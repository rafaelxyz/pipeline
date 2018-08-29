
package jenkins

pipeline {
    agent any
    environment {
        VAR = 'var'
    }
    stages {
        stage('stage1') {
            steps {
                script {
                    lib = load("lib.groovy")
                    lib.getGitCommit()
                }
                echo 'stage1>step1'
            }
        }
    }
}
