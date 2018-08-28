
package jenkins
agent_label = 'master'

pipeline {
    agent any
    environment {
        var1 = 'master'
        TEST_DIR = getTestDir()
        lib = load("${TEST_DIR}/lib.groovy")
        GITCOMMIT = lib.getGitCommit()
    }
    stages {
        stage('stage1') {
            steps {
                echo 'stage1>step1'
                echo "${GITCOMMIT}"
            }
        }
    }
}


def getTestDir() {
    return sh (
            script:
                    """#!/usr/bin/env bash
                cwd="\$(pwd)"
                echo "current working directory: \${cwd}" >&2
                echo "\${cwd}/\${dir}"
            """,
            returnStdout: true
    ).trim()
}
