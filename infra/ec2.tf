data "aws_ami" "desafio-dados-ubuntu-ami" {
  most_recent       = true
  filter {
    name            = "name"
    values          = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-20240426-aced0818-eef1-427a-9e04-8ba38bada306"]
  }
}

data "aws_instances" "all" {}

resource "aws_instance" "desafio-dados-ubuntu" {
  ami             = data.aws_ami.desafio-dados-ubuntu-ami.id
  instance_type   = var.ec2_instance_type
  subnet_id       = resource.aws_subnet.desafio-dados-subnet-1.id
  count           = var.ec2_instance_count
  tags = {
    Name = var.ec2_name
  }
}

resource "aws_ec2_instance_state" "desafio-dados-ubuntu-state" {
  instance_id = aws_instance.desafio-dados-ubuntu[0].id
  state       = var.ec2_state
}