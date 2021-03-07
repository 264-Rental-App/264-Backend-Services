terraform {
  backend "remote" {
    organization = "264-rentals"

    workspaces {
      name = "gcp-infra"
    }
  }
}

provider "google" {
  project = "astute-anagram-303907"
  region  = "us-central1"
  zone    = "us-central1-c"
}