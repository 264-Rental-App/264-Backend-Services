resource "google_service_account" "default_prod" {
  account_id   = "service-account-id"
  display_name = "Service Prod"
}

resource "google_container_cluster" "kubes" {
  name     = "prod-kubes"
  location = "us-central1"

  remove_default_node_pool = true
  initial_node_count       = 1
}

resource "google_container_node_pool" "primary_preemptible_nodes" {
  name       = "my-node-pool"
  location   = "us-central1"
  cluster    = google_container_cluster.kubes.name
  node_count = 1

  node_config {
    preemptible  = true
    machine_type = "g1-small"

    service_account = google_service_account.default_prod.email
    oauth_scopes    = [
      "https://www.googleapis.com/auth/cloud-platform"
    ]
  }
}