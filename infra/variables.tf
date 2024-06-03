variable "aws_region" {
    type = string
}

variable "ec2_instance_type" {
    type = string
}

variable "ec2_state" {
    type = string
}

variable "ec2_name" {
    type = string
}

variable "ec2_instance_count" {
    type = number
}

variable "vpc_cidr_block" {
    type = string
}

variable "vpc_name" {
    type = string
}

variable "subnet1_cidr_block" {
    type = string
}

variable "subnet1_name" {
    type = string
}

variable "subnet2_cidr_block" {
    type = string
}

variable "subnet2_name" {
    type = string
}

variable "subnet3_cidr_block" {
    type = string
}

variable "subnet3_name" {
    type = string
}

variable "subnet4_cidr_block" {
    type = string
}

variable "subnet4_name" {
    type = string
}

variable "tb_namespace_metric" {
    type = string
}

variable "tb_metric_monitored" {
    type = string
}

variable "sns_topic_name" {
    type = string
}