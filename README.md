Consent Management Base
=======================

###About
Sample base application for Consent Management, that uses Spring Boot, MongoDB, Kubernetes and Istio.


###How to run

1. Create Google Cloud Project, Note down the _<PROJECT_ID>_
2. Create Google Kubernetes Cluster, with Istio Support. Note down _<CLUSTER_NAME>, <CLUSTER_ZONE>_
3. Initialize Project
`gcloud init`
4. Connect to Remote Cluster
`gcloud container clusters get-credentials <CLUSTER_NAME> --zone <CLUSTER_ZONE> --project <PROJECT_ID>`
5. Give yourself admin access
`kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin --user=$(gcloud config get-value core/account)`
6. Optional 
Check Istio Services are Up.
`kubectl get services --all-namespaces`
Check the running pods.
`kubectl get pods --all-namespaces`

7. Clone Repository
`git clone https://github.com/bassrehab/consent-base.git`

8. Change Folder `cd consent-base`

9. Deploy MongoDB on GKE cluster
`kubectl apply -f deployment-mongo.yml`

10. Compile Code:
`gradle clean build`

11. Configure GCP & Docker: 
`gcloud auth configure-docker`

12. Build Docker Image:
`docker build -t consent-base-app:1.0 .`

13. Apply kube config to GKE Cluster:
`kubectl apply -f deployment.yml`

14. Check Pods: 
`kubectl get pods`

15. Apply Istio Gateway Config:
`kubectl apply -f istio-gateway.yml`

16. Get Istio INGRESS HOST & PORTS:
`export INGRESS_HOST=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}') &&
  export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].port}');`
 
 17. Check Endpoints: 
 `/consents`
 
 18. For local deployments/tests:
 Uncomment: `compile 'de.flapdoodle.embed:de.flapdoodle.embed.mongo'` in build.gradle
 
 19. For local deployments/tests:
 `gradle bootRun`
 
 
 
 
 
 
