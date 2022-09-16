interface Props {
    title: string,
    bannerUrl: string,
    advertisements: number
}

function Game(game: Props) {

    return (
        <a className="relative rounded-lg overflow-hidden">
          <img src={game.bannerUrl} />
          <div className="w-full pt-16 pb-4 px-4 bg-game-gradient absolute bottom-0 left-0 right-0">
            <strong className="font-bold text-white block">{game.title}</strong>
            <span className="text-zinc-300 text-sm block mt-1">{game.advertisements} {game.advertisements > 1 ? "anúncios" : "anúncio" }</span>
          </div>
        </a>
    )

}

export default Game