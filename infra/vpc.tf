resource "aws_vpc" "desafio-dados-vpc" {
  cidr_block = var.vpc_cidr_block
    tags = {
        Name = var.vpc_name
    }
}