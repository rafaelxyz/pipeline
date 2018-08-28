
package jenkins
agent_label = 'master'

pipeline {
    agent any
    environment {
        var1 = 'master'
        TEST_DIR = getTestDir()
        lib = load("${TEST_DIR}/lib.groovy")
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


def getTestDir() {
    return sh (
            script:
                    """#!/usr/bin/env bash
                dir="test"
                cwd="\$(pwd)"
                echo "current working directory: \${cwd}" >&2
                if [ ! -d \${dir} ]; then
                    echo "no \${dir} directory under \${cwd}" >&2
                    exit 1
                fi
                echo "\${cwd}/\${dir}"
            """,
            returnStdout: true
    ).trim()
}
