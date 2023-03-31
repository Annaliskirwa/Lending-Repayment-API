# Automated deployment of lendtech repayment api using Argocd
By **Annalis Kirwa**

## Requirements
* Docker
* Minikube
* Argocd cli `choco install argocd-cli`
* kubectl cli

## Steps
* Start minikube with docker as the driver  
` minikube start --driver=docker `
* Create namespace  
` kubectl create namespace argocd `
* Install argocd   
` kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml`
* Access the argocd api server: Port forwarding without esposing the svc  
`kubectl port-forward svc/argocd-server -n argocd 8080:443`  
* Access it on the browser via the <a href = "https://localhost:8080">link </a>.  
* The default username is `admin`
* The default password is stored in a secret.yaml called `argocd-initial-admin-secret` in the argocd namespace.  
**Fetching the default password**  
* Run the command  
`kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}"`  
or  
`kubectl -n argocd get secret argocd-initial-admin-secret -o yaml`  
and the decode from base64 with this <a href = "https://www.base64encode.org/">link</a>.  
or using argocd cli  
`argocd admin initial-password -n argocd`  
**Creating the application from the lendtech repository**
* Set the namespace to argocd  
`kubectl config set-context --current --namespace=argocd`
* Create the lendtech argocd application  
`argocd app create lendtech --repo https://github.com/Annaliskirwa/Lending-Repayment-API --path ocp --dest-server https://kubernetes.default.svc --dest-namespace default`  
* View the application status  
`argocd app get lendtech`
* Sync the application
`argocd app sync lendtech`  
* View the deployments and changes via minikube dashboard  
`minikube dashboard`