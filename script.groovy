
package jenkins

pipeline {
    agent any
    environment {
    }
    stages {
        stage('stage1') {
            script {
                lib = load("lib.groovy")
                lib.getGitCommit()
            }
            steps {
                echo 'stage1>step1'
                echo "${GITCOMMIT}"
            }
        }
    }
}
