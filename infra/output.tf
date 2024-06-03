output "desafio-dados-ec2-public-ip" {
  value = aws_instance.desafio-dados-ubuntu[0].public_ip
}

output "account_id" {
  value = data.aws_caller_identity.current.account_id
}


output "caller_arn" {
  value = data.aws_caller_identity.current.arn
}

output "account_user" {
  value = data.aws_caller_identity.current.user_id
}
