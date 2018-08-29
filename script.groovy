
package jenkins

pipeline {
    agent any
    environment {
    }
    stages {
        stage('stage1') {
            steps {
                script {
                    lib = load("lib.groovy")
                    lib.getGitCommit()
                }
                echo 'stage1>step1'
                echo "${GITCOMMIT}"
            }
        }
    }
}
