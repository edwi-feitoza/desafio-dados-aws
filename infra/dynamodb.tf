resource "aws_dynamodb_table" "tb_namespace_metric" {
    name              = var.tb_namespace_metric
    billing_mode      = "PAY_PER_REQUEST"
    hash_key          = "namespace"

    server_side_encryption {
        enabled       = true
        kms_key_arn   = aws_kms_key.desafio-dados-kms-dynamodb-encryption.arn
    }

    attribute {
        name            = "namespace"
        type            = "S"
    }

    tags = {
        Name            = var.tb_namespace_metric
    }
}

resource "aws_dynamodb_table" "tb_metric_monitored" {
    name              = var.tb_metric_monitored
    billing_mode      = "PAY_PER_REQUEST"
    hash_key          = "metricName"
    range_key         = "namespace"

    server_side_encryption {
        enabled       = true
        kms_key_arn   = aws_kms_key.desafio-dados-kms-dynamodb-encryption.arn
    }
    
    
    attribute {
        name            = "metricName"
        type            = "S"
    }
 
    attribute {
        name            = "namespace"
        type            = "S"
    }   
 
    tags = {
        Name            = var.tb_namespace_metric
    }
}