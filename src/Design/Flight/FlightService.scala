package Design.Flight

class FlightService(flights: List[Flight]) {

  var allFlights = flights

  val flightsMap = allFlights.groupBy(_.id)

  val flightsByAirline = allFlights.groupBy(_.airlineName)

  def getFlightsByAirline(airline: String) = flightsByAirline.getOrElse(airline, List())

  def insertFlight(f: Flight) = {
    allFlights = allFlights ++ List(f)
  }

}
