data "aws_caller_identity" "current" {}

provider "aws" {
    region              = var.aws_region
}

terraform {
  required_version      = ">= 0.12"
  backend "s3" {
    bucket              = "desafio-dados-s3-698b6a8e-a6c3-f80a-7e93-e7420dba8ca2"
    key                 = "terraform/terraform-desafio-dados.tfstate"
    region              = "us-east-1"
  }
}
