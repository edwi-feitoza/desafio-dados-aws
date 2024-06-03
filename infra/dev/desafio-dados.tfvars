aws_region                                              = "us-east-1"
ec2_instance_type                                       = "t2.micro"
ec2_state                                               = "running"
ec2_name                                                = "desafio-dados"
ec2_instance_count                                      = 4
vpc_cidr_block                                          = "10.0.0.0/24"
vpc_name                                                = "desafio-dados-vpc"   
subnet1_cidr_block                                      = "10.0.0.0/26"
subnet1_name                                            = "desafio-dados-subnet-1"
subnet2_cidr_block                                      = "10.0.0.64/26"
subnet2_name                                            = "desafio-dados-subnet-2"
subnet3_cidr_block                                      = "10.0.0.128/26"
subnet3_name                                            = "desafio-dados-subnet-3"
subnet4_cidr_block                                      = "10.0.0.192/26"
subnet4_name                                            = "desafio-dados-subnet-4"
tb_namespace_metric                                     = "desafio-dados-namespace-metrics"
tb_metric_monitored                                     = "desafio-dados-metric-monitored"
sns_topic_name                                          = "desafio-dados-sns-eventbridge"