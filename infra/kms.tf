resource "aws_kms_key" "desafio-dados-kms-s3" {
  description = "KMS para encriptação e decriptação de objetos S3 do backend do Terraform"
  deletion_window_in_days = 10
  key_usage = "ENCRYPT_DECRYPT"
}

resource "aws_kms_key" "desafio-dados-kms-dynamodb" {
  description = "KMS para encriptação e decriptação de itens no DynamoDB"
  deletion_window_in_days = 10
  key_usage = "ENCRYPT_DECRYPT"
}

resource "aws_kms_key" "desafio-dados-kms-logs-encryption" {
  description = "KMS para encriptação e decriptação de logs enviados ao CloudWatch"
  deletion_window_in_days = 10
  key_usage = "ENCRYPT_DECRYPT"
}

resource "aws_kms_key" "desafio-dados-kms-dynamodb-encryption" {
  description = "KMS para encriptação e decriptação items no DynamoDB"
  deletion_window_in_days = 10
  key_usage = "ENCRYPT_DECRYPT"
}

resource "aws_kms_key" "desafio-dados-kms-sns-encryption" {
  description = "KMS para encriptação e decriptação items no SNS"
  deletion_window_in_days = 10
  key_usage = "ENCRYPT_DECRYPT"
}

resource "aws_kms_key_policy" "desafio-dados-kms-logs-policy" {
  key_id = aws_kms_key.desafio-dados-kms-logs-encryption.id
  policy = jsonencode({
    "Version": "2012-10-17",
    "Id": "policy-kms-logs",
    "Statement": [
        {
            "Sid": "Enable IAM User Permissions",
            "Effect": "Allow",
            "Principal": {
                "AWS": "arn:aws:iam::${data.aws_caller_identity.current.account_id}:root"
            },
            "Action": "kms:*",
            "Resource": "*"
        },
        {
            "Sid": "Enable logs to use KMS key",
            "Effect": "Allow",
            "Principal": {
                "Service": "logs.us-east-1.amazonaws.com"
            },
            "Action": [
                "kms:Encrypt",
                "kms:Decrypt",
                "kms:ReEncrypt*",
                "kms:GenerateDataKey*",
                "kms:Describe*"
            ],
            "Resource": "*",
            "Condition": {
                "ArnLike": {
                    "kms:EncryptionContext:aws:logs:arn": "arn:aws:logs:us-east-1:${data.aws_caller_identity.current.id}:*"
                }
            }
        }
    ]
})
}