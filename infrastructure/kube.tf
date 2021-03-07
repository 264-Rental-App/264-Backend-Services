resource "google_service_account" "default_prod" {
  account_id   = "service-account-id"
  display_name = "Service Prod"
}

resource "google_container_cluster" "kubes" {
  name     = "prod-kubes"
  location = "us-central1-a"

  remove_default_node_pool = true
  initial_node_count       = 1
}

resource "google_container_node_pool" "primary_preemptible_nodes" {
  name       = "kubes-node-pool"
  location   = "us-central1-a"
  cluster    = google_container_cluster.kubes.name
  node_count = 1

  node_config {
    preemptible  = true
    machine_type = "n1-standard-2"

    service_account = google_service_account.default_prod.email
    oauth_scopes = [
      "https://www.googleapis.com/auth/cloud-platform"
    ]
  }
}
