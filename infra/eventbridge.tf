resource "aws_cloudwatch_event_rule" "desafio_dados_cinco_minutos" {
  name                = "every-five-minutes"
  description         = "Fires every five minutes"
  schedule_expression = "rate(5 minutes)"
}

resource "aws_cloudwatch_event_target" "sns_target" {
  rule      = aws_cloudwatch_event_rule.desafio_dados_cinco_minutos.name
  target_id = "SendToSNS"
  arn       = aws_sns_topic.desafio_dados_sns_eventbridge.arn
}