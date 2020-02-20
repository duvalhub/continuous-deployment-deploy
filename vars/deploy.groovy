import com.duvalhub.deploy.parameters.Parameters

def call(Parameters parameters) {

    echo "### Deploying app version '${processBranchNameResponse.version}' in '${processBranchNameResponse.deployEnv}'"
    
    DeployRequest deployRequest = deploy.getDeployRequest()
    
    new DeployRequest(conf, processBranchNameResponse.version, processBranchNameResponse.deployEnv)
    deploy(deployRequest)

}