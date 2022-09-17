import { useState, FormEvent } from 'react'
import * as Dialog from '@radix-ui/react-dialog'
import { GameController, Check } from 'phosphor-react'
import * as Checkbox from '@radix-ui/react-checkbox'
import * as ToggleGroup from '@radix-ui/react-toggle-group'

import Input from '../../components/Form/Input'
import { Game } from '../../App'

interface Props {
    games: Game[]
}

function CreateAdvertisementModal({games}: Props) {

    const [weekDays, setWeekDays] = useState<string[]>([])
    const [useVoiceChanel, setUseVoiceChanel] = useState<Checkbox.CheckedState>(false)

    function handleCreateAdvertisement(event: FormEvent) {
      event.preventDefault()

      const formData = new FormData(event.target as HTMLFormElement)
      const entriesData = Object.fromEntries(formData)

      const data = {
        ...entriesData,
        gameId: Number(entriesData.gameId),
        yearsPlaying: Number(entriesData.yearsPlaying),
        weekDays: weekDays.map(item => parseInt(item)),
        useVoiceChanel
      }

      fetch('http://127.0.0.1:8080/ads', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      }).then(response => console.log(response.status))
    }

    return (
        <Dialog.Portal>
          <Dialog.Overlay className="bg-black/60 inset-0 fixed" />

          <Dialog.Content className="fixed bg-[#2A2634] py-8 px-10 text-white top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 rounded-lg w-[480px] shadow-lg shadow-black/25">
            <Dialog.Title className="text-3xl font-black">Publique um anúncio</Dialog.Title>

            <form className="mt-8 flex flex-col gap-4" onSubmit={handleCreateAdvertisement}>
              <div className="flex flex-col gap-2">
                <label htmlFor="game" className="font-semibold">Qual o game?</label>
                <select
                    id="gameId"
                    name="gameId"
                    className="bg-zinc-900 py-3 px-4 rounded text-sm placeholder:text-zinc-500 appearance-none"
                    defaultValue=""
                >
                    <option disabled value="">Selecione o game que deseja jogar</option>

                    {games.map((game: Game) => (
                        <option key={game.id} value={game.id}>{game.title}</option>
                    ))}
                </select>
              </div>

              <div className="flex flex-col gap-2">
                <label htmlFor="name" className="font-semibold">Seu nome (ou o nickname)?</label>
                <Input
                  id="name"
                  name="name"
                  placeholder="como te chamam dentro do game?"
                />
              </div>

              <div className="grid grid-cols-2 gap-6">
                <div className="flex flex-col gap-2">
                  <label htmlFor="yearsPlaying">Joga há qunatos anos?</label>
                  <Input
                    id="yearsPlaying"
                    name="yearsPlaying"
                    type="number"
                    placeholder="Tudo bem ser ZERO"
                  />
                </div>
                <div className="flex flex-col gap-2">
                  <label htmlFor="discord">Qual seu discord?</label>
                  <Input
                    id="discord"
                    name="discord"
                    type="text"
                    placeholder="Usuario#0000"
                  />
                </div>
              </div>

              <div className="flex gap-6">
                <div className="flex flex-col gap-2">
                  <label htmlFor="weekDays">Quando costuma jogar?</label>
                  
                    <ToggleGroup.Root
                        id="weekDays"
                        type="multiple"
                        className="grid grid-cols-4 gap-2"
                        value={weekDays}
                        onValueChange={setWeekDays}
                    >
                        <ToggleGroup.Item value="0" className={`w-8 h-8 rounded ${weekDays.includes('0') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Domingo">D</ToggleGroup.Item>
                        <ToggleGroup.Item value="1" className={`w-8 h-8 rounded ${weekDays.includes('1') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Segund">S</ToggleGroup.Item>
                        <ToggleGroup.Item value="2" className={`w-8 h-8 rounded ${weekDays.includes('2') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Terça">T</ToggleGroup.Item>
                        <ToggleGroup.Item value="3" className={`w-8 h-8 rounded ${weekDays.includes('3') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Quarta">Q</ToggleGroup.Item>
                        <ToggleGroup.Item value="4" className={`w-8 h-8 rounded ${weekDays.includes('4') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Quinta">Q</ToggleGroup.Item>
                        <ToggleGroup.Item value="5" className={`w-8 h-8 rounded ${weekDays.includes('5') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Sexta">S</ToggleGroup.Item>
                        <ToggleGroup.Item value="6" className={`w-8 h-8 rounded ${weekDays.includes('6') ? 'bg-violet-500': 'bg-zinc-900'}`} title="Sábado">S</ToggleGroup.Item>
                    </ToggleGroup.Root>
                 
                </div>
                <div className="flex flex-col gap-2 flex-1">
                  <label htmlFor="hourStart">Qual horário do dia?</label>
                  <div className="grid grid-cols-2 gap-2">
                    <Input
                      id="hourStart"
                      name="hourStart"
                      type="time"
                      placeholder="De"
                    />
                    <Input
                      id="hourEnd"
                      name="hourEnd"
                      type="time"
                      placeholder="Até"
                    />
                  </div>
                </div>
              </div>

              <label className="mt-2 flex gap-2 text-sm items-center cursor-pointer">
                <Checkbox.Root
                  name="useVoiceChanel"
                  id="useVoiceChanel"
                  className="w-6 h-6 p-1 rounded bg-zinc-900"
                  checked={useVoiceChanel}
                  onCheckedChange={checked => setUseVoiceChanel(checked)}
                >
                    <Checkbox.Indicator>
                        <Check className="w-4 h-4 text-emerald-400" />
                    </Checkbox.Indicator>
                </Checkbox.Root>
                Costumo me conectar ao chat de voz
              </label>

              <footer className="mt-4 flex justify-end gap-4">
                <Dialog.Close
                  type="button"
                  className="bg-zinc-500 px-5 h-12 rounded-md font-semibold hover:bg-zinc-600"
                >
                  Cancelar
                </Dialog.Close>
                <button
                  type="submit"
                  className="bg-violet-500 px-5 h-12 rounded-md font-semibold flex items-center gap-3 hover:bg-violet-600"
                >
                  <GameController size={24} /> Encontrar duo
                </button>
              </footer>
            </form>
            
          </Dialog.Content>
        </Dialog.Portal>
    )
}

export default CreateAdvertisementModal