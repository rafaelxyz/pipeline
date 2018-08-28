package jenkins

def getGitCommit() {
    return sh (
            script:
                    """
                echo GETGITCOMMIT
            """,
            returnStatus: false,
            returnStdout: true
    ).trim()
}

