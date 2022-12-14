import { useState, useEffect } from 'react'
import { View, TouchableOpacity, Image, FlatList, Text } from 'react-native'
import { useRoute, useNavigation } from '@react-navigation/native'
import { SafeAreaView } from 'react-native-safe-area-context'
import { Entypo } from '@expo/vector-icons'

import { Background } from '../../components/Background'
import { Heading } from '../../components/Heading'
import { DuoMatch } from '../../components/DuoMatch'

import { GameParams } from '../../@types/navigation'

import { styles } from './styles'
import { THEME } from '../../theme'
import logoImg from '../../assets/logo-nlw-esports.png'
import { DuoCard } from '../../components/DuoCard'

export interface DuoCardProps {
    id: number,
    name: string,
    yearsPlaying: number,
    weekDays: number[],
    hourStart: Date,
    hourEnd: Date,
    useVoiceChanel: boolean,
    createdAt: Date
}

export function Game() {

    const [advertisements, setAdvertisements] = useState<DuoCardProps[]>([])
    const [openModal, setOpenModal] = useState<boolean>(false)
    const [discord, setDiscord] = useState<string>("")

    const route = useRoute()
    const game = route.params as GameParams

    const navigation = useNavigation()

    useEffect(() => {
        fetch(`http://192.168.0.113:8080/games/${game.id}/ads`)
        .then(response => response.json())
        .then(data => setAdvertisements(data))
    }, [])

    function handleGoBack() {
        navigation.goBack()
    }

    async function handleDiscordByAd(id: number) {
        await fetch(`http://192.168.0.113:8080/ads/${id}/discord`)
        .then(response => response.text())
        .then(result => setDiscord(result))

        setOpenModal(!openModal)
    }

    return (
        <Background>
            <SafeAreaView style={styles.container}>
                <View style={styles.header}>
                    <TouchableOpacity onPress={handleGoBack}>
                        <Entypo
                            name="chevron-thin-left"
                            color={THEME.COLORS.CAPTION_300}
                            size={20}
                        />
                    </TouchableOpacity>

                    <Image
                        source={logoImg}
                        style={styles.logo}
                    />

                    <View style={styles.right} />
                </View>

                <Image
                    source={{uri: game.bannerUrl}}
                    style={styles.cover}
                    resizeMode="cover"
                />

                <Heading
                    title={game.title}
                    subTitle="Conecte-se e comece a jogar!"
                />

                <FlatList
                    data={advertisements}
                    keyExtractor={item => item.id}
                    renderItem={({ item }) => (
                      <DuoCard
                        data={item}
                        onConnect={() => handleDiscordByAd(item.id)}
                      />
                    )}
                    horizontal
                    style={styles.containerList}
                    contentContainerStyle={advertisements.length > 0 ? styles.contentList : styles.emptyListContainer}
                    showsHorizontalScrollIndicator={false}
                    ListEmptyComponent={() => (
                        <Text style={styles.emptyListText}>N??o h?? an??ncios publicados ainda.</Text>
                    )}
                />

                <DuoMatch
                    visible={openModal}
                    discord={discord}
                    onClose={() => setOpenModal(!openModal)}
                />

            </SafeAreaView>
        </Background>
    );
}