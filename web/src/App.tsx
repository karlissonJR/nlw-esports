import { useEffect, useState } from 'react'

import * as Dialog from '@radix-ui/react-dialog'

import GameBanner from './components/GameBanner'
import CreateAdvertisementArea from './components/CreateAdvertisementArea'
import CreateAdvertisementModal from './components/CreateAdvertisementModal'

import logo from './assets/logo.svg'

import './styles/main.css'

export interface Game {
  id: number,
  title: string,
  bannerUrl: string,
  advertisements: number
}

function App() {

  const [games, setGames] = useState<Game[]>([])

  useEffect(() => {
    fetch('http://127.0.0.1:8080/games')
    .then(response => response.json())
    .then(data => {
      setGames(data)
    })
  }, [])

  return (
    <div className="max-w-[1344px] mx-auto flex flex-col items-center my-20" >
      <img src={logo} alt="logo" />
      
      <h1 className="text-6xl text-white font-black mt-20" >
        Seu <span className="text-transparent bg-nlw-gradient bg-clip-text">duo</span> está aqui.
      </h1>

      <div className='grid grid-cols-6 gap-6 mt-16'>
        {games.map(item => (
          <GameBanner
            key={item.id}
            title={item.title}
            bannerUrl={item.bannerUrl}
            advertisements={item.advertisements}
          />
        ))}
      </div>

      <Dialog.Root>
        <CreateAdvertisementArea />
        <CreateAdvertisementModal games={games} />
      </Dialog.Root>

    </div>
  )
}

export default App
