resource "google_sql_database" "rental_database" {
  name     = "rental-db"
  instance = google_sql_database_instance.rental_instance.name
}

resource "google_sql_database_instance" "rental_instance" {
  name   = "rental-db-server"
  database_version = "POSTGRES_12"
  region = "us-central1"
  settings {
    tier = "db-f1-micro"
  }

}