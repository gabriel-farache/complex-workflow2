# complex.workflow2

complex-workflow2

## Prerequisites
* Java 11+ is installed.
* Apache Maven 3.8.6 or later is installed.
* [Quarkus CLI](https://quarkus.io/guides/cli-tooling) or [Knative Workflow CLI](https://kiegroup.github.io/kogito-docs/serverlessworkflow/latest/testing-and-troubleshooting/kn-plugin-workflow-overview.html) 0.21.3 or later is installed.
* (Optional) Docker is installed.
* (Optional) Podman is installed.
* (Optional) Kubernetes CLI is installed.
* Visual Studio Code with [Red Hat Java Extension](https://marketplace.visualstudio.com/items?itemName=redhat.java) and 
[Red Hat Serverless Workflow Editor](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-extension-serverless-workflow-editor) 
are installed to edit your workflows.

## References
* [About OpenShift Serverless Logic](https://openshift-knative.github.io/docs/docs/latest/serverless-logic/about.html)
* [SonataFlow Guides](https://kiegroup.github.io/kogito-docs/serverlessworkflow/latest/index.html)

## Running complex.workflow2 in Quarkus dev mode
You can run your application in dev mode that enables live coding using:

```shell script
mvn compile quarkus:dev
```

## Testing with curl
First, validate the workflows exposed by the application:

```shell script
curl -v -H "Content-Type: application/json" http://localhost:8080/management/processes
```
(complex.workflow2 should be included in the returned array)

Run the following to create an instance of the complex.workflow2 workflow:

```shell script
curl -XPOST -H "Content-Type: application/json" http://localhost:8080/complex.workflow2 -d@input.json
```

Response:
```
{
    "id": "_GENERATED_UUID_",
    "workflowdata": {
        "workflowOptions": {
            "currentVersion": {
                "id": "complex.workflow2",
                "name": "complex.workflow2"
            },
            "upgradeOptions": [],
            "migrationOptions": [],
            "newOptions": [],
            "continuationOptions": [],
            "otherOptions": []
        }
    }
}
```

# Dev UI Tools
Use the `Serverless Workflow Tools` to manage and monitor the published workflows:
```
http://localhost:8080/q/dev-v1/org.kie.kogito.kogito-quarkus-serverless-workflow-devui/workflowInstances
```

Use the `Data Index GraphQL UI` to query the state of the [Data Index service](https://sonataflow.org/serverlessworkflow/main/data-index/data-index-core-concepts.html):
```
http://localhost:8080/q/dev-v1/org.kie.kogito.kogito-addons-quarkus-data-index-inmemory/dataindex
```