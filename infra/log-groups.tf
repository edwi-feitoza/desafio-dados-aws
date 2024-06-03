resource "aws_cloudwatch_log_group" "desafio-dados-log-group" {
  name              = "/desafio-dados/metrics-collector"
  retention_in_days = 7
  kms_key_id        = aws_kms_key.desafio-dados-kms-logs-encryption.arn
  tags = {
    Name = "desafio-dados-log-group"
  }
}