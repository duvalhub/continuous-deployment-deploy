package com.duvalhub.deploy.deploy

import com.duvalhub.BaseObject
import com.duvalhub.appconfig.AppConfig
import com.duvalhub.deploy.parameters.Parameters

import com.duvalhub.git.GitCloneRequest
import com.duvalhub.initializeworkdir.InitializeWorkdirIn

class Deploy extends BaseObject {
    Parameters parameters
    String app_workdir
    AppConfig app_config

    PerformGitActions(Parameters parameters, InitializeWorkdirIn initWorkDirIn, AppConfig appConfig) {
        this.parameters = parameters
        this.app_workdir = initWorkDirIn.appWorkdir
        this.app_config = appConfig
    }

    String getVersionControl() {
        return this.app_config.app.version_control
    }

    String getVersion() {
        return this.parameters.version
    }

    String getFlowType() {
        return this.parameters.flow_type
    }

    String getGitUri() {
        return this.parameters.git_repository
    }

    String getRegistryApi() {
        return this.app_config.docker.registry_api
    }
    String getNamespace() {
        return this.app_config.docker.namespace
    }
    String getRepository() {
        return this.app_config.docker.repository
    }

}