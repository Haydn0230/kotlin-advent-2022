if [ "$1" == "" ]; then
  echo "\n ERROR: Please enter a topic as argument to script ./reset-test-data <your-topic-name> \n"
  exit
fi

if [ "$1" == "local" ]; then
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.event.avro
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.market.avro
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.outcome.avro
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.node.avro
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.price.avro
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic gstp.sportsbook.catalogue.local.participant.avro

  echo "Your offsets has been reset to the beginning for all local catalogue topics"
else
  echo "Your offset is currently: "
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --describe
  docker exec broker kafka-consumer-groups --bootstrap-server localhost:29092 --group catalogue.writer --reset-offsets --to-earliest --execute --topic $1
  echo "Your offset has been reset to the beginning for topic $1"
fi

