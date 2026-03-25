package com.duvalhub.deploy.parameters

class Parameters {

    String git_repository
    String environment
    String version
    String label
    String configGitBranch

    Parameters(String git_repository, String environment, String version, String label, String configGitBranch) {
        this.git_repository = git_repository
        this.environment = environment
        this.version = version
        this.label = label
        this.configGitBranch = configGitBranch
    }
}
