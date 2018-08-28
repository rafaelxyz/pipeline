package jenkins

def getGitCommit() {
    return sh (
            script:
                    """
                git rev-parse HEAD
            """,
            returnStatus: false,
            returnStdout: true
    ).trim()
}

