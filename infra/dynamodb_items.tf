resource "aws_dynamodb_table_item" "desafio-dados-ec2-items" {
    table_name = aws_dynamodb_table.tb_namespace_metric.name
    hash_key   = aws_dynamodb_table.tb_namespace_metric.hash_key
    item = <<EOF
    {
        "namespace": {"S": "AWS/EC2"},
        "metrics": {
            "L": [
                {"S": "CPUCreditBalance"},
                {"S": "CPUCreditUsage"},
                {"S": "CPUSurplusCreditBalance"},
                {"S": "CPUSurplusCreditsCharged"},
                {"S": "CPUUtilization"},
                {"S": "DiskReadBytes"},
                {"S": "DiskReadOps"},
                {"S": "DiskWriteBytes"},
                {"S": "DiskWriteOps"},
                {"S": "MetadataNoToken"},
                {"S": "NetworkIn"},
                {"S": "NetworkOut"},
                {"S": "NetworkPacketsIn"},
                {"S": "NetworkPacketsOut"},
                {"S": "StatusCheckFailed"},
                {"S": "StatusCheckFailed_Instance"},
                {"S": "StatusCheckFailed_System"}
            ]
        }
    }
    EOF
}

resource "aws_dynamodb_table_item" "desafio-dados-dynamodb-items" {
    table_name = aws_dynamodb_table.tb_namespace_metric.name
    hash_key   = aws_dynamodb_table.tb_namespace_metric.hash_key
    item = <<EOF
    {
        "namespace": {"S": "AWS/DynamoDB"},
        "metrics": {
            "L": [
                {"S": "AccountMaxReads"},
                {"S": "AccountMaxTableLevelReads"},
                {"S": "AccountMaxTableLevelWrites"},
                {"S": "AccountMaxWrites"},
                {"S": "AccountProvisionedReadCapacityUtilization"},
                {"S": "AccountProvisionedWriteCapacityUtilization"},
                {"S": "ConsumedReadCapacityUnits"},
                {"S": "ConsumedWriteCapacityUnits"},
                {"S": "MaxProvisionedTableReadCapacityUtilization"},
                {"S": "MaxProvisionedTableWriteCapacityUtilization"},
                {"S": "ProvisionedReadCapacityUnits"},
                {"S": "ProvisionedWriteCapacityUnits"}
            ]
        }
    }
    EOF   
}