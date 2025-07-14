package Design.Flight

class OperatingFlightService(flightsInfo: List[OperatingFlight]) {

  def operationalFlights = flightsInfo.groupBy(_.flightId)
}
