resource "aws_s3_bucket" "desafio-dados-s3" {
  bucket = "desafio-dados-s3-${random_uuid.desafio-dados-uuid.result}"
  tags = {
    Name = "desafio-dados-s3"
  }
}

resource "aws_s3_bucket_ownership_controls" "desafio-dados-s3-ownership-controls" {
  bucket = aws_s3_bucket.desafio-dados-s3.id
  rule {
    object_ownership = "BucketOwnerPreferred"
  }
}

resource "aws_s3_bucket_acl" "desafio-dados-s3-acl" {
  depends_on = [aws_s3_bucket_ownership_controls.desafio-dados-s3-ownership-controls]
  bucket = aws_s3_bucket.desafio-dados-s3.id
  acl = "private"
}

resource "aws_s3_bucket_server_side_encryption_configuration" "desafio-dados-s3-encryption" {
  bucket = aws_s3_bucket.desafio-dados-s3.id
  rule {
    apply_server_side_encryption_by_default {
      kms_master_key_id = aws_kms_key.desafio-dados-kms-s3.arn
      sse_algorithm     = "aws:kms"
    }
  }
}