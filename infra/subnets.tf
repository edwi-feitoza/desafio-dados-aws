resource "aws_subnet" "desafio-dados-subnet-1" {
  vpc_id     = resource.aws_vpc.desafio-dados-vpc.id
  cidr_block = var.subnet1_cidr_block 
  tags = {
    Name = var.subnet1_name
  }
}

resource "aws_subnet" "desafio-dados-subnet-2" {
  vpc_id     = resource.aws_vpc.desafio-dados-vpc.id
  cidr_block = var.subnet2_cidr_block
  tags = {
    Name = var.subnet2_name
  }
}

resource "aws_subnet" "desafio-dados-subnet-3" {
  vpc_id     = resource.aws_vpc.desafio-dados-vpc.id
  cidr_block = var.subnet3_cidr_block
  tags = {
    Name = var.subnet3_name
  }
}

resource "aws_subnet" "desafio-dados-subnet-4" {
  vpc_id     = resource.aws_vpc.desafio-dados-vpc.id
  cidr_block = var.subnet4_cidr_block
  tags = {
    Name = var.subnet4_name
  } 
}