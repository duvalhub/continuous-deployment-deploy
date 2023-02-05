package com.duvalhub.deploy.parameters

class Parameters {

    String git_repository
    String environment
    String version
    String configGitBranch

    Parameters(String git_repository, String environment, String version, String configGitBranch) {
        this.git_repository = git_repository
        this.environment = environment
        this.version = version
        this.configGitBranch = configGitBranch
    }
}
