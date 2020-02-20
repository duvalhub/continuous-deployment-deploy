package com.duvalhub.deploy.parameters

class Parameters {

    String git_repository
    String environment
    String version

    Parameters(String git_repository, String environment, String version) {
        this.git_repository = git_repository
        this.environment = environment
        this.version = version
    }
}
