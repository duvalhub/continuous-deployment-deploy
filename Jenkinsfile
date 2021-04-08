@Library(['deploy-library@master', 'shared-library@master']) _

import com.duvalhub.deploy.parameters.Parameters
import com.duvalhub.git.GitCloneRequest
import com.duvalhub.git.GitRepo
import com.duvalhub.initializeworkdir.InitializeWorkdirIn
import com.duvalhub.appconfig.AppConfig
import com.duvalhub.deploy.DeployRequest

dockerSlave {
    properties([
        parameters([
            string(defaultValue: 'duvalhub/continuous-deployment-test-app', name: 'GIT_REPOSITORY'),
            choice(choices: ['dev', 'stage', 'prod'], name: 'ENVIRONMENT'),
            string(defaultValue: 'latest', name: 'VERSION'),
            string(defaultValue: 'false', name: 'DRY_RUN')
        ])
    ])

    if ( params.DRY_RUN == 'false' ) {
        Parameters parameters = new Parameters(params.GIT_REPOSITORY, params.ENVIRONMENT, params.VERSION)

        checkout scm

        String[] repo_parts = parameters.git_repository.split('/')
        String org = repo_parts[0]
        String repo = repo_parts[1]
        GitRepo appGitRepo = new GitRepo(org, repo, "develop")

        InitializeWorkdirIn initWorkDirIn = new InitializeWorkdirIn(appGitRepo)
        initWorkDirIn.setCloneAppRepo(false)
        AppConfig appConfig = initializeWorkdir.stage(initWorkDirIn)
        deploy(new DeployRequest(appConfig, parameters.version, parameters.environment))

    } else {
        echo "Dry run detected! Aborting pipeline."
    }

}
