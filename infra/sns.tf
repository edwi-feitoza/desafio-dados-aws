resource "aws_sns_topic" "desafio_dados_sns_eventbridge" {
    name = var.sns_topic_name
    kms_master_key_id = aws_kms_key.desafio-dados-kms-sns-encryption.arn
}