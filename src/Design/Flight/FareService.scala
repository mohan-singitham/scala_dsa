package Design.Flight

class FareService(fareTypes: List[FareType], routes: List[Route], fares: List[Fare]) {

  val fareTypeId = fareTypes.groupBy(_.id)

  def getFares(source: String, to: String) = {
    val routeIds = routes.filter(route => route.fromCity == source && route.toCity == to).map(_.id)
    val allFares = fares.filter(fare => routeIds.contains(fare.routeId))

    allFares.map(fare => (fareTypeId.get(fare.fareTypeId), fare.price, fare.validFrom, fare.validTo))
  }
}
