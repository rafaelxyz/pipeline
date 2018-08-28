agent_label = 'master'

pipeline {
    agent any
    environment {
        var1 = 'master'
    }
    stages {
        stage('stage1') {
            agent {
                label agent_label
            }
            steps {
                echo 'stage1>step1'
            }
        }
        stage('stage2') {
            agent {
                label agent_label
            }
            steps {
                echo 'stage2>step1'
            }
        }
    }
}
